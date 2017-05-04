/**
 * @file	bcd_counter.cpp
 * @date	Aug 12, 2014
 * @author	aseemm@gmail.com
 * @brief       bcd counter (binary counter + bcd decoder) + tb (stim)
 *              stimul -> binary counter -> bcd decoder
 */

#include <systemc.h>
#include <iostream>
#include <iomanip>

using namespace std;

/**
 * @brief       stimul, clock & reset generation
 */
SC_MODULE(stimul) {
  sc_out<bool> clk;
  sc_out<bool> reset;
  

  void c_gen();

  void r_gen();
  
  SC_CTOR(stimul) {
    SC_THREAD(c_gen);
    SC_THREAD(r_gen);
  }
};

   
void stimul::c_gen() {
  bool t=false;
  
  while(true) {
    t = !t;
    clk.write(t);
    wait(5, SC_US); // frequency
  }
}

/**
 * @brief       reset generation
 */    
void stimul::r_gen() {
  
  bool t = true;
  reset.write(t);
  wait(17, SC_US);
  t = false;
  reset.write(t);
  wait(10, SC_US);
  t = true;
  reset.write(t);
}  

/**
 * @brief       binary counter
 */
SC_MODULE(counter) {
  sc_in<bool> clk;
  sc_in<bool> reset;
  sc_out<unsigned short int> cnt;
  
 private:
  // variable to store counter value
  unsigned short int cnt_int;
  
  /**
   * @brief       counter 
   */
  void count();
  
 public:
  SC_CTOR(counter) {
    SC_THREAD(count);
    sensitive << clk.pos();
  }
};

/**
 * @brief       counter 
 */
void counter::count() {
  while(true) {
    if(reset.read()==0) {
      cnt_int = 0;
    } else {
      cnt_int = (cnt_int+1)%100;
    }     
    cnt.write(cnt_int);
    // cout << ">> " << setw(8) << sc_time_stamp() << ": [counter] count_value " << cnt_int << "\n";
    wait();
  }
}

/**
 * @brief       bcd decoder
 */
SC_MODULE(bcd_decoder) {
  sc_in<unsigned short int> val;
  sc_out<char> hi, lo;
  
  /**
   * @brief       decode process
   */
  void decode();
  
  SC_CTOR(bcd_decoder) {
    SC_METHOD(decode);
    sensitive << val;
  }
};

void bcd_decoder::decode() {
  unsigned int val_int;
  
  val_int = val.read();
  lo.write(val_int%10);
  hi.write((val_int/10)%10);
  cout << ">> " << setw(8) << sc_time_stamp() << ": [bcd decoder] count = "<< hex << val_int << " -> hi:lo = " << dec << ((val_int/10)%10) << (val_int%10) << "\n";
}

/**
 * @brief       sc_main
 */
int sc_main(int argc, char *argv[]) {
  
  sc_signal<bool> clock, reset;
  sc_signal<unsigned short int> count_val;
  sc_signal<char> v_hi, v_lo;
  
  sc_set_time_resolution(1, SC_US);

  // stimul -> binary counter -> bcd decoder hookups
  stimul stim("stimuli_mod");
  stim.clk(clock);
  stim.reset(reset);
  
  counter count("counter");
  count.clk(clock);
  count.reset(reset);
  count.cnt(count_val);
  
  bcd_decoder bcd("bcd_decode");
  bcd.val(count_val);
  bcd.hi(v_hi);
  bcd.lo(v_lo);
  
  sc_trace_file *tf = sc_create_vcd_trace_file("traces");  
  sc_trace(tf, reset, "reset");
  sc_trace(tf, clock, "clock");
  sc_trace(tf, count_val, "counter_value");
  sc_trace(tf, v_hi, "BCD_High");
  sc_trace(tf, v_lo, "BCD_low");
  sc_trace(tf, count.cnt, "internal_count");
  
  int n_cycles;
  if(argc != 2) {
    cout << "default n_cycles = 200\n";
    n_cycles = 200;
  }
  else
    n_cycles = atoi(argv[1]);
  
  sc_start(n_cycles, SC_US);
  sc_close_vcd_trace_file(tf);
  
  return 0;
}
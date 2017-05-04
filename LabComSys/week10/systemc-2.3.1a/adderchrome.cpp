#include <systemc.h>
SC_MODULE(sc_andm)
{
  sc_in<bool> a, b;
  sc_out<bool> c;
 
  void do_and()
  {
    c.write(a.read() & b.read());
  }
 
  SC_CTOR(sc_andm)
  {
    SC_METHOD(do_and);
    sensitive << a << b;
  }
};


SC_MODULE (sc_adder)
{
  sc_in<bool> a,b,cin;
  sc_out<bool> sum,cout;

  SC_CTOR (sc_adder)
  {
    SC_METHOD (process);
      sensitive << a << b << cin;
    }  

  void process()
  {
    bool aANDb,aXORb,cinANDaXORb;
  
    aANDb = a.read() & b.read();
    aXORb = a.read() ^ b.read();
    cinANDaXORb = cin.read() & aXORb;

    sum = aXORb ^ cin.read();
    cout = aANDb | cinANDaXORb;
  }

};  
 
int sc_main(int argc, char* argv[])
{
  sc_set_time_resolution(1, SC_PS);
  sc_time t1(1, SC_US);
  sc_clock clk("clock",10 ,0.5);
  
  sc_adder sc_add1("adder1");
 
  sc_signal<bool> a, b, cin;
  sc_signal<bool> cout, sum;
 


  sc_add1.a(a);
  sc_add1.b(b);
  sc_add1.cin(cin);
  sc_add1.cout(cout);
  sc_add1.sum(sum);



 
  sc_trace_file *wf = sc_create_vcd_trace_file("adder");
  sc_trace(wf, sc_add1.a, "a");
  sc_trace(wf, sc_add1.b, "b");
  sc_trace(wf, sc_add1.cin, "cin");
  sc_trace(wf, sc_add1.cout, "cout");
  sc_trace(wf, sc_add1.sum, "sum");

  a.write(0);
  b.write(0);
  cin.write(0);
 
  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(1);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);
 
  sc_start(t1);
  a.write(0);
  b.write(1);
  cin.write(0);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(0);
  b.write(1);
  cin.write(1);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(1);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(1);
  b.write(0);
  cin.write(1);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(1);
  b.write(1);
  cin.write(0);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);

  sc_start(t1);
  a.write(1);
  b.write(1);
  cin.write(1);

  sc_start(t1);
  a.write(0);
  b.write(0);
  cin.write(0);
 
  sc_start(t1);
  sc_stop();
 
  sc_close_vcd_trace_file(wf);
  return(0);
}

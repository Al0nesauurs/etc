// All systemc modules should include systemc.h header file
#include "modules/driver.h"
#include "modules/ctrl.h"
#include "modules/adder1.h"
#include "modules/adder2.h"


// sc_main in top level function like in C++ main
int sc_main(int argc, char* argv[]) {

	sc_set_time_resolution(1, SC_PS);
	sc_time t1(1, SC_US);
	sc_clock clk("clock",10 ,0.5);

	
	sc_signal<sc_int<8>> num;
	sc_signal<sc_int<8>> i;
	sc_signal<sc_int<8>> sum;

	sc_signal<bool> stop;
	sc_signal<bool> out;
	sc_signal<bool> bit;
	sc_signal<bool> start;
	sc_signal<bool> start_medthe;

	adder1 MyAdder1("adder1_block");
	MyAdder1.start(start_c);
	MyAdder1.stop(stop);
	MyAdder1.A(sum);
	MyAdder1.B(i);
	MyAdder1.C(sum);

	add2 abc("add2);
	2.start();
	2.stop();
	2.i();
	2.newi();
	2.clk();
	add
	di def("drive");
	.N();
	.start();
	.sum();
	.outready();
	c cfg("ctrl");
	.N();
	.i_start();
	.outready();
	.o_start();
	.stop();
	.i();
	er1 ijk("add");
	.start();
	.stop();
	.A();
	.B();
	.C();
	dr.N_val = 5;

	sc_trace_file *wf = sc_create_vcd_trace_file("sumwave");
	sc_trace(wf, ad.B, "i");
	sc_trace(wf, r.sm, "sum");
	sc_trace(wf, a.clk, "clock");
	sc_trace(wf, d.s, "start");
	sc_trace(wf, d.oy, "outready");
	sc_trace(wf, c.sp, "stop");

	sc_start(t1);
	//sc_stop();
	sc_close_vcd_trace_file(wf);


	return(0);
}


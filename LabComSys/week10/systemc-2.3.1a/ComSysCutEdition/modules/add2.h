
#ifndef ADDER2_H_
#define ADDER2_H_

#include "systemc.h"

SC_MODULE (adder2) {

	sc_in_clk myclock;
	sc_in<bool> start;
	sc_in<bool> stop;
	sc_in<sc_int<8>> A;
	sc_out<sc_int<8>> B;

	bool isActive;

	SC_CTOR (adder2){
		SC_METHOD(increment_i);
		dont_initialize();
		sensitive << clk.pos();
		isActive = false;
	}

	void increment_i();

};

#endif /* ADDER2_H_ */

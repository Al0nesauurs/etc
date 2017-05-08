
#ifndef ADDER1_H_
#define ADDER1_H_

#include "systemc.h"

SC_MODULE (adder1) {

	sc_in<bool> start;
	sc_in<bool> stop;
	sc_in<sc_int<8>> A;
	sc_in<sc_int<8>> B;
	sc_out<sc_int<8>> C;

	bool isActive;

	SC_CTOR (adder1){
		SC_METHOD(aplusb);
		dont_initialize();
		sensitive << start << B;
		isActive = false;
	}

	void aplusb();

};


#endif /* ADDER1_H_ */

/*
 * ctrl.h
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#ifndef CTRL_H_
#define CTRL_H_

#include "systemc.h"

SC_MODULE(ctrl){

	sc_in<bool> ;
	sc_in<sc_int<8>> ;
	sc_in<sc_int<8>> ;
	sc_out<bool> ;
	sc_out<bool> ;
	sc_out<bool> ;

	SC_CTOR(ctrl){
		SC_METHOD(startControl);
		dont_initialize();
		sensitive <<  << ;
	}

	void startControl();

};

#endif /* CTRL_H_ */

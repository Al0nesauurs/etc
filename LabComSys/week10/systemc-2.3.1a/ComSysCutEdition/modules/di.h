/*
 * driver.h
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#ifndef DRIVER_H_
#define DRIVER_H_

#include "systemc.h"

SC_MODULE (driver) {

	sc_in<bool> ;
	sc_in<sc_int<8>>;
	sc_out<bool> ;
	sc_out<sc_int<8>> ;

	sc_int<8> ;
	bool isActive;

	SC_CTOR (driver){
		SC_METHOD();
		sensitive << ;
		isActive = ;
	}

	void drive();

};

#endif /* DRIVER_H_ */

/*
 * adder2.cpp
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#include "adder2.h"

void adder2::increment_i(){
	sc_int<8> ;
	if(!isActive && start.read()){
		isActive = true;
		i_tmp = 0;
		newi.write();
	}
	else if(!stop.read() && isActive){
		i_tmp = i.read();
		i_tmp += 1;
		newi.write();

	}
	else if(stop.read()){
		isActive = false;
	}

}

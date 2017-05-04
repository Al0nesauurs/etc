/*
 * adder1.cpp
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#include "adder1.h"

void adder1::(){
	if(stop.read()){
		isActive = false;
	}
	else if(isActive){
		C.write(A.read() + B.read());
	}
	else if(start.read()){
		C.write(0);
		isActive = true;
	}

}

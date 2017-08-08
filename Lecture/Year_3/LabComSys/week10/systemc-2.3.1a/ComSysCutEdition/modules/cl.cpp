/*
 * ctrl.cpp
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#include "ctrl.h"

void ctrl::startControl(){

	if(i.read() == N.read()){
		o_start.write();
		stop.write();
		outready.write();
	}
	else if(i_start.read()){
			outready.write();
			o_start.write();
			stop.write();
	}
}

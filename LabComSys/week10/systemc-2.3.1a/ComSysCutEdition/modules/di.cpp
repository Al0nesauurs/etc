/*
 * driver.cpp
 *
 *  Created on: Apr 27, 2017
 *      Author: cpe-ku
 */

#include "driver.h"

void driver::drive(){
		if(outready.read()){
			isActive = false;
			start.write(false);
			cout << "Output Ready! : sum = " << sum.read() << endl;
		}
		else{
			start.write(true);
			N.write(N_val);
		}
}


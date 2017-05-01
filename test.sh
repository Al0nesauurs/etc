#!/bin/bash

a=8
while [ "$a" -lt 15 ]    # this is loop1
do
   	touch $a.txt
	a=`expr $a + 1`
done

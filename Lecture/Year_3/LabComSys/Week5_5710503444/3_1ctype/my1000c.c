#include <stdio.h>
 
 void myprint(void);
 void myprint() {
   int array[1001][1001], multiply[1001][1001];
   int m, n, c, d, k, num, sum, countx, county = 0;
    
   FILE *file;
   file = fopen("./mat1000.dat", "r");
   if (file) {
    while (fscanf(file, "%d", &num)!=EOF){
      if(m==0) {
        m = num;
        n = num;
      }
   else {
      if(countx<1000) {
        array[countx][county] = num;
        countx++;
       }
   else {
        countx = 0;
        county++;
        array[countx][county] = num;
       }
    }
  }
  fclose(file);
 }
											      
   for (c = 0; c < m; c++) {
    for (d = 0; d < n; d++) {
     for (k = 0; k < m; k++) {
       sum = sum + array[c][k]*array[k][d];
   }
      multiply[c][d] = sum;
      sum = 0;
    }
 }
 }

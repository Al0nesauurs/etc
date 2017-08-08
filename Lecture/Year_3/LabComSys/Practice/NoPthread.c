#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
	int count =0;
	clock_t begin = clock();
		for(int i =0;i<2000000;i++)
	{
		count++;
		printf("%d\n",count );
	}
	clock_t end = clock();
	printf ("time = %d\n",(int)(end-begin));
}
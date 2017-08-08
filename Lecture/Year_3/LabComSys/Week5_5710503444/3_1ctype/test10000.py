import ctypes
import time

start = time.time()

testlib = ctypes.CDLL('./my10000c.so')
testlib.myprint()
end = time.time()
print(end - start)

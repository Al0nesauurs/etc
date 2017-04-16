import time
import numpy as np
start = time.time()
mx = np.fromfile('mat1000.dat',dtype=int)
mx*mx
end = time.time()
print(end - start)


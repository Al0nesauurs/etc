import sys
import os
import numpy as np
import cv2

def split_into_rgb_channels(image):
  '''Split the target image into its red, green and blue channels.
  image - a numpy array of shape (rows, columns, 3).
  output - three numpy arrays of shape (rows, columns) and dtype same as
           image, containing the corresponding channels. 
  '''
  red = image[:,:,2]
  green = image[:,:,1]
  blue = image[:,:,0]
  return red, green, blue

def checkimage (red,green,blue,name,ext):
  num=0 
  for row in range (0,len(red)-1):
    for col in range (0,len(red[row])-1):
      if (red[row,col] > 128 and blue[row,col] > 128 and green[row,col] > 128):
       # print ("Image name: {}.".format(name+ext))
        num+=1
       # print(num)
#      else:
#        print("fail")


  return num


def main():
  ''' This function searches for a folder images/knowpapa subfolder, and splits
   all images found in that folder into its equivalent rgb channel. 
   It saves each image appending the terms 'red', 'green' and
  'blue' to the orginal filename.
  '''
  runner=1
  count_grey = 0
  idle_grey=0
  imagesdir = os.path.abspath(os.path.join(os.curdir, 'img'))
  print ('Searching for images in {} Directory'.format(imagesdir))
  exts = ['.bmp', '.pbm', '.pgm', '.ppm', '.sr', '.ras', '.jpeg', '.jpg', 
    '.jpe', '.jp2', '.tiff', '.tif', '.png']
  for dirname, dirnames, filenames in os.walk(imagesdir):
    for filename in filenames:
      name, ext = os.path.splitext(filename)
      img = cv2.imread(os.path.join(dirname, filename))
      red, green, blue = split_into_rgb_channels(img)
      #print (img)  
      idle_grey=checkimage(red,green,blue,name,ext)
      count_grey+=idle_grey
        #  cv2.imwrite(os.path.join(dirname, name+color+ext), img)
      print (str(runner) + '.' + '\tFilename: ' + filename)
      print ('\tGrey Pixel: ' + str(idle_grey))
      runner+=1
      print("==================================================")

  print(count_grey)
if __name__ == "__main__":
    main()
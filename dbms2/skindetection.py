import cv2
import os
a=256
b=256
c=256
nonskin_array = [[ [0 for col in range(a)] for col in range(b)] for row in range(c)]
skin_array =  [[ [0 for col in range(a)] for col in range(b)] for row in range(c)]
cnt=0
for image_path in os.listdir('F:/5th-semester/dbms2/ibtd/Mask'):
  ext=image_path.split('.')
  if ext[1]=='bmp':
    mask_img=cv2.imread(os.path.join('F:/5th-semester/dbms2/ibtd/Mask',image_path))
    unmask_image_path=ext[0]+'.jpg'
    unmask_img=cv2.imread(os.path.join('F:/5th-semester/dbms2/ibtd',unmask_image_path))
    width,height,channel=mask_img.shape
    for x in range(width):
      for y in range(height):
        b=mask_img[x][y][0]
        g=mask_img[x][y][1]
        r=mask_img[x][y][2]

        if b>250 and g>250 and r>250:#white pixel
          #go to non skin array and iterate
          b=unmask_img[x][y][0]
          g=unmask_img[x][y][1]
          r=unmask_img[x][y][2]

          nonskin_array[r][g][b]=nonskin_array[r][g][b]+1
        else:
          skin_array[r][g][b]=skin_array[r][g][b]+1

#summation of pixels in skin and non skin array
sum_skin=0
sum_nonskin=0

for x in range(256):
  for y in range(256):
    sum_skin=sum_skin+sum(skin_array[x][y])
    sum_nonskin=sum_nonskin+sum(nonskin_array[x][y])
    
#probability array
a = 256
b = 256
c = 256
p_array = [[ [0 for col in range(a)] for col in range(b)] for row in range(c)]

for x in range(256):
    for y in range(256):
        for z in range(256):
            skin_array[x][y][z] = skin_array[x][y][z] / sum_skin
            nonskin_array[x][y][z] = nonskin_array[x][y][z] / sum_nonskin
            if nonskin_array[x][y][z] != 0:
                p_array[x][y][z] = skin_array[x][y][z] / nonskin_array[x][y][z]
            else:
                p_array[x][y][z]=0


test_img = cv2.imread('F:/5th-semester/dbms2/IMG_0652.JPG',cv2.IMREAD_UNCHANGED)
T = 0.15
height, width, channels = test_img.shape
for x in range(height):
  for y in range(width):
    b=test_img[x][y][0]
    g=test_img[x][y][1]
    r=test_img[x][y][2]

    if p_array[r][g][b] < T:
      # mask image
      test_img[x][y][0] = 255
      test_img[x][y][1] = 255
      test_img[x][y][2] = 255

cv2.imshow('ImageWindow',test_img)
# Visual sorter

This project will be like [this video](https://www.youtube.com/watch?v=kPRA0W1kECg). It will essentially just sort arrays and draw what's happening to them on the screen. The program will use vertical staples to represent integer values in the array it's sorting. The higher the staples, the higher the value. Although, I will make sure to normalize the values to make sure that the height of the staples do not exceed the height of the window. Something like: staple height = (staple value / max staple value) * window height. 

# The structure of the program

The structure is going to be extremely simple, so I'm not going to bother with drawing any class diagrams. The program will contain two classes: Sorter and Renderer. The Sorters job is to sort an array and store which indeces it's accessing and swapping etc. The Renderers job is to draw what the Sorter is doing.  

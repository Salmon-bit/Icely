# Wooden Pack Generator

To use this tool you need to install python.

## Instruction

1. Download all `.py` files and `templates` folder.
2. Bring `templates` folder near to python files.
3. Run `main.py`
4. Choose the type of wood:
 - Oak
 - Birch
 - Spruce
 - Jungle
 - Mangroove
 - Dark Oak
 - Acacia

_PS. You need to type wood type in the snake case like: mangroove, dark_oak, spruce._

Tool will automatically generate all `.json` files and source code that you need to add in `.java` files.

5. Rename all files:
 - If filename is `blockstates` and this `.json` files is in the `log` dir, rename it into `frosted_{wood_type}_log.json` and put it in `blockstates` folder.
 - If there are other symbols in the name like: `model_horizontal.json` and it is in `log` folder, rename it like this: `frosted_{wood_type}_log_horizontal.json`.
6. Add `Java` Code to their classes.

All the code you need to add is in the `java` folder. All files have `.txt` extension and their names are similar to the `Java` classes.
If file name is `FreezerWand.txt` you need to find `FreezerWand.java` class and paste the text from the text file to the class in the Map.
And do it for the all text files in the `java` folder.

7. Check all filenames.

My tool may be not 100% well, so double-check everything yourself that you add into your mod.

8. Draw textures.

You need to draw:
 - `frosted_{wood_type}_log.png`
 - `frosted_{wood_type}_log_top.png`
 - `frosted_{wood_type}_planks.png`
 - `frosted_{wood_type}_trapdoor.png`
 - `frosted_{wood_type}_door.png`

9. Build and Complile your mod to check everything.
10. And of course rate my tool =)
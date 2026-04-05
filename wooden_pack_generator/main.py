import os
from wooden_pack_generator import planks
from wooden_pack_generator import java
from wooden_pack_generator import log

wood_type = input("Введите тип древесины: ").lower()
match wood_type:
    case 'oak':
        rus_wood_type = ["Дубовое", "Дуьовый", "Дубовая", "Дубовые"]
    case 'birch':
        rus_wood_type = ["Берёзовое", "Берёзовый", "Берёзовая", "Берёзовые"]
    case 'spruce':
        rus_wood_type = ["Еловое", "Еловый", "Еловая", "Еловые"]
    case 'acacia':
        rus_wood_type = ["Акациевое", "Акациевый", "Акациевая", "Акациевые"]
    case 'dark_oak':
        rus_wood_type = ["Из Тёмного Дуба"]
    case 'jungle':
        rus_wood_type = ["Джунглевое", "Джунглевый", "Джунглевая", "Джунглевые"]
    case 'mangroove':
        rus_wood_type = ["Мангровое", "Мангровый", "Мангровая", "Мангровые"]
    case _:
        raise BaseException

print("Генерирую структуру папок...")
try:
    os.system("rmdir output /s /q")
except:
    pass
os.mkdir("output")
os.chdir("output")
os.mkdir("planks")
os.mkdir("java")
os.mkdir("button")
os.mkdir("chipped_log")
os.mkdir("chipped_wood")
os.mkdir("fence")
os.mkdir("fence_gate")
os.mkdir("log")
os.mkdir("pressure_plate")
os.mkdir("stairs")
os.mkdir("wood")
os.chdir("..")

print("Генерирую код...")
java.generate(wood_type)
print("Генерирую доски...")
planks.generate(wood_type, rus_wood_type)
print("Генерирую бревно...")
log.generate(wood_type, rus_wood_type)
# print("Генерирую дерево")
# wood.generate(wood_type, rus_wood_type)
# print("Генерирую обтёсанное бревно...")
# chipped_log.generate(wood_type, rus_wood_type)
# print("Генерирую обтёсаннное дерево...")
# chipped_wood.generate(wood_type, rus_wood_type)
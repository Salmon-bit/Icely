import os
from wooden_pack_generator import planks

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
        rus_wood_type = ["Из тёмного дуба"]
    case 'jungle':
        rus_wood_type = ["Джунглевое", "Джунглевый", "Джунглевая", "Джунглевые"]
    case 'mangroove':
        rus_wood_type = ["Мангровое", "Мангровый", "Мангровая", "Мангровые"]
    case _:
        raise BaseException

try:
    os.system("rmdir output /s /q")
except:
    pass
os.mkdir("output")
os.chdir("output")
os.mkdir("planks")
os.chdir("..")

print("Генерирую доски...")

planks.generate(wood_type, rus_wood_type)
import json
import os

wood_type = input("Введите тип древесины: ")
rus_wood_type = input("Введите русское название этого типа: ")

try:
    os.system("rmdir output /s /q")
os.mkdir("output")
os.chdir("output")

print("Генерирую бревно...")


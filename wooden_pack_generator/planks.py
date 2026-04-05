def generate(wood_type: str, rus_wood_type: list[str, str, str, str]) -> None:
        with open("output/planks/model.json", 'w+', encoding='UTF-8') as file:
            with open("templates/planks/model.json", "r", encoding='UTF-8') as temp:
                template = temp.read().strip()
                template = template.replace("***", wood_type)

                file.write(template)

        with open("output/planks/blockstate.json", 'w+', encoding='UTF-8') as file:
            with open("templates/planks/blockstates.json", "r", encoding='UTF-8') as temp:
                template = temp.read().strip()
                template = template.replace("***", wood_type)

                file.write(template)

        with open("output/planks/item_model.json", 'w+', encoding='UTF-8') as file:
            with open("templates/planks/item_model.json", "r", encoding='UTF-8') as temp:
                template = temp.read().strip()
                template = template.replace("***", wood_type)

                file.write(template)

        with open("output/planks/lang_en_us.json", 'w+', encoding='UTF-8') as file:
            with open("templates/planks/lang_en_us.json", "r", encoding='UTF-8') as temp:
                template = temp.read().strip()
                template = template.replace("***", wood_type, 1)
                template = template.replace("***", wood_type.title(), 1)

                file.write(template)

        if wood_type != "dark_oak":
            with open("output/planks/lang_ru_ru.json", 'w+', encoding='UTF-8') as file:
                with open("templates/planks/lang_ru_ru.json", "r", encoding='UTF-8') as temp:
                    template = temp.read().strip()
                    template = template.replace("***", wood_type, 1)
                    template = template.replace("***", rus_wood_type[3].title(), 1)

                    file.write(template)
        else:
            with open("output/planks/lang_ru_ru.json", 'w+', encoding='UTF-8') as file:
                with open("templates/planks/lang_ru_ru_dark_oak.json", "r", encoding='UTF-8') as temp:
                    file.write(temp.read().strip())


if __name__ == "__main__":
    generate("spruce", ["Еловое", "Еловый", "Еловая", "Еловые"])
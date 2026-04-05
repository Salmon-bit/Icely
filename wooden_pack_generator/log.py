def generate(wood_type, rus_wood_type):
    with open("output/log/model.json", 'w', encoding='UTF-8') as file:
        with open('templates/log/model.json', 'r', encoding='UTF-8') as template_file:
            template = template_file.read().strip()
            template = template.replace("***", wood_type)

            file.write(template)

    with open("templates/log/model_horizontal.json", 'r', encoding='UTF-8') as template_file:
        with open('output/log/model_horizontal.json', 'w', encoding='UTF-8') as file:
            template = template_file.read().strip()
            template = template.replace("***", wood_type)

            file.write(template)

    with open("templates/log/blockstates.json", 'r', encoding='UTF-8') as template_file:
        with open('output/log/blockstates.json', 'w', encoding='UTF-8') as file:
            template = template_file.read().strip()
            template = template.replace("***", wood_type)

            file.write(template)

    with open("templates/log/item_model.json", 'r', encoding='UTF-8') as template_file:
        with open('output/log/item_model.json', 'w', encoding='UTF-8') as file:
            template = template_file.read().strip()
            template = template.replace("***", wood_type)

            file.write(template)
    if wood_type != "dark_oak":
        with open("templates/log/lang_en_us.json", 'r', encoding='UTF-8') as template_file:
            with open('output/log/lang_en_us.json', 'w', encoding='UTF-8') as file:
                template = template_file.read().strip()
                template = template.replace("***", wood_type, 1)
                template = template.replace("***", wood_type.title(), 1)

                file.write(template)

        with open("templates/log/lang_ru_ru.json", 'r', encoding='UTF-8') as template_file:
            with open('output/log/lang_ru_ru.json', 'w', encoding='UTF-8') as file:
                template = template_file.read().strip()
                template = template.replace("***", wood_type, 1)
                template = template.replace("***", rus_wood_type[0].title(), 1)

                file.write(template)
    else:
        with open("templates/log/lang_en_us_dark_oak.json", 'r', encoding='UTF-8') as template_file:
            with open("output/log/lang_en_us.json", "w", encoding='UTF-8') as file:
                template = template_file.read().strip()
                file.write(template)

        with open("templates/log/lang_ru_ru_dark_oak.json", 'r', encoding='UTF-8') as template_file:
            with open("output/log/lang_ru_ru.json", "w", encoding='UTF-8') as file:
                template = template_file.read().strip()
                file.write(template)
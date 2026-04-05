def generate(wood_type: str) -> None:
    upper_wt = wood_type.upper()
    lower_wt = wood_type.lower()

    with open("output/java/ModBlocks.txt", 'w', encoding='utf-8') as file:
        with open("templates/java/ModBlocks.txt", 'r', encoding='utf-8') as template:
            temp = template.read().strip()
            temp = temp.replace("***", upper_wt).replace("@@@", lower_wt)

            file.write(temp)

    with open("output/java/FreezerWand.txt", 'w', encoding='utf-8') as file:
        with open("templates/java/FreezerWand.txt", 'r', encoding='utf-8') as template:
            temp = template.read().strip()
            temp = temp.replace("***", upper_wt)

            file.write(temp)

    with open("output/java/ModItemGroups.txt", 'w', encoding='utf-8') as file:
        with open("templates/java/ModItemGroups.txt", 'r', encoding='utf-8') as template:
            temp = template.read().strip()
            temp = temp.replace("***", upper_wt)

            file.write(temp)
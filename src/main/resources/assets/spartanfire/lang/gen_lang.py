import json

mat_names = ['dragonbone', 'myrmexdesert', 'myrmexjungle', 'dragonbone_fire', 'dragonbone_ice', 'dragonbone_lightning', 'myrmexdesert_venom', 'myrmexjungle_venom', 'dragonsteel_fire', 'dragonsteel_ice', 'dragonsteel_lightning']

mat_desc = {
    'dragonbone_fire':"Ignites and knocks back targets, deals extra damage to ice dragons", 
    'dragonbone_ice':"Slows and knocks back targets, deals extra damage to fire dragons", 
    'dragonbone_lightning':"Strikes targets with lightning and applies glowing", 
    'myrmexdesert':"+4 damage against non-arthropods and deathworms", 
    'myrmexjungle':"+4 damage against non-arthropods and deathworms",
    'myrmexdesert_venom':"Poisons the target on hit", 
    'myrmexjungle_venom':"Poisons the target on hit",
    'dragonsteel_fire':"Ignites and knocks back targets", 
    'dragonsteel_ice':"Slows and knocks back targets", 
    'dragonsteel_lightning':"Strikes targets with lightning and applies glowing"
    }

weapons = [
    'dagger', 'longsword', 'katana', 'saber', 'rapier',
    'greatsword', 'hammer', 'warhammer', 'spear', 'halberd', 
    'pike', 'lance', 'throwing_knife', 'tomahawk', 'javelin', 
    'boomerang', 'battleaxe', 'flanged_mace', 'glaive', 
    'longbow', 'heavy_crossbow', 'quarterstaff'
    ]
ranged = ['longbow', 'heavy_crossbow']

gen_dict = {'item.spartanfire.witherbone_handle':"Witherbone Handle", "item.spartanfire.witherbone_pole":"Witherbone Pole"}

for mat in mat_names:
    if "bone" in mat:
        base_name = "Dragon Bone"
        if "fire" in mat:
            friendly_name = "Flamed " + base_name
        elif "ice" in mat:
            friendly_name = "Iced " + base_name
        elif "lightning" in mat:
            friendly_name = "Lightning " + base_name
        else:
            friendly_name = base_name
    elif "jungle" in mat:
        base_name = "Jungle Myrmex "
        if "venom" in mat:
            friendly_name = base_name + "Stinger"
        else:
            friendly_name = base_name + "Chitin"
    elif "desert" in mat:
        base_name = "Desert Myrmex "
        if "venom" in mat:
            friendly_name = base_name + "Stinger"
        else:
            friendly_name = base_name + "Chitin"
    elif "steel" in mat:
        unfriendly_name = mat.replace("_", " ").title().split()
        friendly_name = " ".join(unfriendly_name[::-1])
    for weapon in weapons:
        if "bow" in weapon:
            gen_dict["item.spartanfire." + weapon + "_" + mat] = friendly_name + "-Strengthened " + weapon.replace("_", " ").title()
        else:
            gen_dict["item.spartanfire." + weapon + "_" + mat] = friendly_name + " " + weapon.replace("_", " ").title()
        

for mat, desc in mat_desc.items():
    gen_dict["tooltip.spartanfire.trait." + mat] = desc

gen_dict.update({
    "material.spartanfire.dragonbone":"Dragonbone",
    "material.spartanfire.dragonbone_fire":"Flamed Dragonbone",
    "material.spartanfire.dragonbone_ice":"Iced Dragonbone",
    "material.spartanfire.myrmexdesert":"Desert Myrmex Chitin",
    "material.spartanfire.myrmexjungle":"Jungle Myrmex Chitin",
    "material.spartanfire.myrmexdesert_venom":"Desert Myrmex Stinger",
    "material.spartanfire.myrmexjungle_venom":"Jungle Myrmex Stinger",
    "material.spartanfire.dragonsteel_ice":"Ice Dragonsteel",
    "material.spartanfire.dragonsteel_fire":"Fire Dragonsteel"
})

with open('en_us.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)


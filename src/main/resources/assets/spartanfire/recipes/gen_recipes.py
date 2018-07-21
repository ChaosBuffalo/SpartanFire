import json

mat_names = ['dragonbone']

def gen_katana_recipe_for_mat(mat_name, mod_name):
    gen_dict = {
        "type": "minecraft:crafting_shaped",
        "pattern": [
                    "  i",
                    " i ",
                    "h  "
                    ],
        "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                    },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                    }
            },
        "result": {
            "item": mod_name + ":katana_" + mat_name
        },
    "conditions": [
            {
            "type": "ore_dict_exists",
            "ore_dict": "ingot" + mat_name.capitalize()
            }
        ]
    }
    with open('katana_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_greatsword_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                " i ",
                "iii",
                "ihi"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":greatsword_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('greatsword_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_longsword_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                " i ",
                " i ",
                "ihi"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":longsword_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('longsword_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_saber_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                " i",
                " i",
                "ih"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":saber_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('saber_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_rapier_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "  i",
                "ii ",
                "hi "
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":rapier_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('rapier_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)  

def gen_spear_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "i",
                "p"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "p": {
                    "item": "spartanweaponry:material",
                    "data": 1
                }
            },
            "result": {
                "item": mod_name + ":spear_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('spear_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

def gen_dagger_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "i",
                "h"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":dagger_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('dagger_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_pike_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "i",
                "p",
                "p"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "p": {
                    "item": "spartanweaponry:material",
                    "data": 1
                }
            },
            "result": {
                "item": mod_name + ":pike_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('pike_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

def gen_lance_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "i",
                "p",
                "h"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "p": {
                    "item": "spartanweaponry:material",
                    "data": 1
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":lance_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('lance_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

def gen_halberd_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                " i",
                "ip",
                "i "
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "p": {
                    "item": "spartanweaponry:material",
                    "data": 1
                },
            },
            "result": {
                "item": mod_name + ":halberd_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('halberd_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

def gen_warhammer_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "ii",
                " h"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":warhammer_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('warhammer_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_throwing_axe_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "hi",
                " i"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":throwing_axe_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('throwing_axe_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_hammer_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "iii",
                "iii",
                " h "
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":hammer_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('hammer_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_throwing_knife_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "hi"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                }
            },
            "result": {
                "item": mod_name + ":throwing_knife_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('throwing_knife_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_longbow_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
                "pattern": [
                            "hwi",
                            "w s",
                            "iss"
                        ],
                "key": {
                    "i": {
                        "type": "forge:ore_dict",
                        "ore": "ingot" + mat_name.capitalize()
                    },
                    "h": {
                        "item": "spartanweaponry:material",
                        "data": 0
                    },
                    "s": {
                        "type": "forge:ore_dict",
                        "ore": "string"
                    },
                    "w": {
                        "type": "forge:ore_dict",
                        "ore": "stickWood"
                    }
                },
            "result": {
                "item": mod_name + ":longbow_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('longbow_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_crossbow_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
                 "pattern": [
                                "bsi",
                                "sw ",
                                "i h"
                            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "h": {
                    "item": "spartanweaponry:material",
                    "data": 0
                },
                "b": {
                    "item": "minecraft:bow"
                },
                "s": {
                    "type": "forge:ore_dict",
                    "ore": "string"
                },
                "w": {
                    "type": "forge:ore_dict",
                    "ore": "logWood"
                }
            },
            "result": {
                "item": mod_name + ":crossbow_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('crossbow_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def gen_javelin_recipe(mat_name, mod_name):
    gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": [
                "pi"
            ],
            "key": {
                "i": {
                    "type": "forge:ore_dict",
                    "ore": "ingot" + mat_name.capitalize()
                },
                "p": {
                    "item": "spartanweaponry:material",
                    "data": 1
                },
            },
            "result": {
                "item": mod_name + ":javelin_" + mat_name
            },
            "conditions": [
                {
                    "type": "ore_dict_exists",
                    "ore_dict": "ingot" + mat_name.capitalize()
                }
            ]
        }
    with open('javelin_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

MOD_NAME = "spartanfire"

for each in mat_names:
    gen_katana_recipe_for_mat(each, MOD_NAME)
    gen_greatsword_recipe(each, MOD_NAME)
    gen_longsword_recipe(each, MOD_NAME)
    gen_saber_recipe(each, MOD_NAME)
    gen_rapier_recipe(each, MOD_NAME)
    gen_spear_recipe(each, MOD_NAME)
    gen_dagger_recipe(each, MOD_NAME)
    gen_pike_recipe(each, MOD_NAME)
    gen_lance_recipe(each, MOD_NAME)
    gen_halberd_recipe(each, MOD_NAME)
    gen_warhammer_recipe(each, MOD_NAME)
    gen_throwing_axe_recipe(each, MOD_NAME)
    gen_hammer_recipe(each, MOD_NAME)
    gen_throwing_knife_recipe(each, MOD_NAME)
    gen_longbow_recipe(each, MOD_NAME)
    gen_crossbow_recipe(each, MOD_NAME)
    gen_javelin_recipe(each, MOD_NAME)

import json

mat_names = ['dragonbone', 'dragonbone_fire', 'dragonbone_ice',
    'dragonbone_lightning', 'myrmexdesert', 'myrmexdesert_venom', 
    'myrmexjungle', 'myrmexjungle_venom', 'dragonsteel_fire',
    'dragonsteel_ice', 'dragonsteel_lightning']

melee_weapons = ['dagger', 'longsword', 'katana', 'saber', 'rapier',
    'greatsword', 'hammer', 'warhammer', 'spear', 'halberd', 'pike', 
    'lance', 'longbow', 'heavy_crossbow', 'throwing_knife', 'tomahawk', 
    'javelin', 'boomerang', 'battleaxe', 'flanged_mace', 'glaive', 'quarterstaff']

def gen_simple_item_model(mat_name, weapon_name, mod_name):
    gen_dict = {
        "parent":"spartanweaponry:item/" + weapon_name + "_wood",
        "textures": {
            "layer0": mod_name + ":items/" + weapon_name + "_" + mat_name
        }
    }
    with open(weapon_name + '_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4) 

def gen_pulling(mat_name, weapon_name, mod_name, pull_count, base_pull):
    gen_dict = {
        "parent":"spartanweaponry:item/" + weapon_name + "_wood_pulling_" + base_pull,
        "textures": {
            "layer0": mod_name + ":items/" + weapon_name + "_" + mat_name + "_pulling_" + pull_count
        }
    }
    with open(weapon_name + '_' + mat_name + "_pulling_" + pull_count + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)

def gen_firing(mat_name, weapon_name, mod_name):
    gen_dict = {
        "parent": "spartanweaponry:item/" + weapon_name + "_wood_pulling_0",
        "textures": {
            "layer0": mod_name + ":items/" + weapon_name + "_" + mat_name + "_loaded"
        }
    }
    with open(weapon_name + '_' + mat_name + '_firing.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)


def gen_loaded(mat_name, weapon_name, mod_name):
    gen_dict = {
        "parent": "spartanweaponry:item/" + weapon_name + "_wood",
        "textures": {
            "layer0": mod_name + ":items/" + weapon_name + "_" + mat_name + "_loaded"
        }
    }
    with open(weapon_name + '_' + mat_name + '_loaded.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)


def gen_heavy_crossbow(mat_name, weapon_name, mod_name):
    gen_pulling(mat_name, weapon_name, mod_name, "0", "0")
    gen_pulling(mat_name, weapon_name, mod_name, "1", "0")
    gen_pulling(mat_name, weapon_name, mod_name, "2", "0")
    gen_firing(mat_name, weapon_name, mod_name)
    gen_loaded(mat_name, weapon_name, mod_name)
    mat_base = mod_name + ":items/" + weapon_name + "_" + mat_name
    gen_dict = {
        "parent": "spartanweaponry:item/" + weapon_name + "_wood",
        "textures": {
            "layer0": mat_base + "_standby"
        },
        "overrides": [
            {
                "predicate": {
                    "pulling": 1
                },
                "model": mat_base + "_pulling_0"
            },
            {
                "predicate": {
                    "pulling": 1,
                    "pull": 0.65
                },
                "model": mat_base + "_pulling_1"
            },
            {
                "predicate": {
                    "pulling": 1,
                    "pull": 0.9
                },
                "model": mat_base + "_pulling_2"
            },
            {
                "predicate": {
                    "pulling": 0,
                    "pull": 1.0
                },
                "model": mat_base + "_loaded"
            },
            {
                "predicate": {
                    "pulling": 1,
                    "pull": 1.0
                },
                "model": mat_base + "_firing"
            }
      ]
    }
    with open(weapon_name + '_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)


def gen_longbow(mat_name, weapon_name, mod_name):
    gen_pulling(mat_name, weapon_name, mod_name, "0", "0")
    gen_pulling(mat_name, weapon_name, mod_name, "1", "1")
    gen_pulling(mat_name, weapon_name, mod_name, "2", "2")
    mat_base = mod_name + ":items/" + weapon_name + "_" + mat_name
    gen_dict = {
    "parent": "spartanweaponry:item/" + weapon_name + "_wood",
        "textures": {
            "layer0": mat_base + "_standby"
        },
        "overrides": [
            {
              "predicate": {
                "pulling": 1
              },
              "model": mat_base + "_pulling_0"
            },
            {
              "predicate": {
                "pulling": 1,
                "pull": 0.65
              },
              "model": mat_base + "_pulling_1"
            },
            {
              "predicate": {
                "pulling": 1,
                "pull": 0.9
              },
              "model": mat_base + "_pulling_2"
            }
        ]
    }
    with open(weapon_name + '_' + mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile, indent=4)


MOD_NAME = "spartanfire"

for mat_name in mat_names:
    for weapon_type in melee_weapons:
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
        gen_simple_item_model(mat_name, weapon_type, MOD_NAME)
    gen_longbow(mat_name, 'longbow', MOD_NAME)
    gen_heavy_crossbow(mat_name, 'heavy_crossbow', MOD_NAME)

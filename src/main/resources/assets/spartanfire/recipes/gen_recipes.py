import json

class MatDefinition(object):

    def __init__(self, mat_name, ingot_entry, conditions):
        self.mat_name = mat_name
        self.ingot_entry = ingot_entry
        self.conditions = conditions
        self.replace_tip = False
        self.tip_entry = None

dragonMat = MatDefinition('dragonbone', 
    {"type": "forge:ore_dict", "ore": "ingotDragonbone"},
    [])
desertMat = MatDefinition('desert',
    {"item": "iceandfire:myrmex_desert_chitin", "data": 0},
    [])
jungleMat = MatDefinition('jungle',
    {"item": "iceandfire:myrmex_jungle_chitin", "data": 0},
    [])
desertPoisonMat = MatDefinition('desert_venom',
    {"item": "iceandfire:myrmex_desert_chitin", "data": 0},
    [])
desertPoisonMat.replace_tip = True
desertPoisonMat.tip_entry = {"item": "iceandfire:myrmex_stinger", "data": 0}
junglePoisonMat = MatDefinition('jungle_venom',
    {"item": "iceandfire:myrmex_jungle_chitin", "data": 0},
    [])
junglePoisonMat.replace_tip = True
junglePoisonMat.tip_entry = {"item": "iceandfire:myrmex_stinger", "data": 0}
iceDragonSteelMat = MatDefinition('ice_dragonsteel',
  {"type": "forge:ore_dict", "ore": "ingotIceDragonsteel"},
  [])
fireDragonSteelMat = MatDefinition('fire_dragonsteel',
  {"type": "forge:ore_dict", "ore": "ingotFireDragonsteel"},
  [])

mats = [dragonMat, desertMat, jungleMat, desertPoisonMat, junglePoisonMat,
        iceDragonSteelMat, fireDragonSteelMat]

class RecipePattern(object):

    def __init__(self, pattern, keys, tip):
        self.pattern = pattern
        self.keys = keys
        self.tip = tip

patterns = {}
HAFT_ENTRY = {"h": {"item": "spartanfire:witherbone_handle", "data": 0}}
POLE_ENTRY = {"p": {"item": "spartanfire:witherbone_pole", "data": 0}}
HAFT_POLE = {"p": {"item": "spartanfire:witherbone_pole", "data": 0},
             "h": {"item": "spartanfire:witherbone_handle", "data": 0}}
BOW_KEYS = {"h": {"item": "spartanfire:witherbone_handle", "data": 0},
            "s": {"type": "forge:ore_dict",
                  "ore": "string"},
            "w": {"type": "forge:ore_dict",
                  "ore": "stickWood"}}
CROSSBOW_KEYS = {"h": {"item": "spartanfire:witherbone_handle", "data": 0},
                "b": {"item": "minecraft:bow"},
                "s": {"type": "forge:ore_dict",
                      "ore": "string"},
                "w": {"type": "forge:ore_dict",
                      "ore": "logWood"}}
STICK_HAFT = { "h": {"item": "spartanfire:witherbone_handle", "data": 0},
                "s": {"type": "forge:ore_dict",
                      "ore": "stickWood"}}
BOOMERANG_KEYS = {"w": {"type": "forge:ore_dict",
                        "ore": "plankWood"}}

patterns["katana"] = RecipePattern(
    ["  i", 
     " i ", 
     "h  "], 
    HAFT_ENTRY, (0, 2))
patterns["greatsword"] = RecipePattern(
    [" i ",
     "iii", 
     "ihi"],
    HAFT_ENTRY, (0, 1))
patterns["longsword"] = RecipePattern(
    [" i ", 
     " i ", 
     "ihi"],
    HAFT_ENTRY, (0, 1))
patterns["saber"] = RecipePattern(
    [" i",
     " i",
     "ih"],
    HAFT_ENTRY, (0, 1))
patterns["rapier"] = RecipePattern(
    ["  i",
     "ii ",
     "hi "],
    HAFT_ENTRY, (0, 2))
patterns["spear"] = RecipePattern(
    ["i",
     "p"],
    POLE_ENTRY, (0, 0))
patterns["dagger"] = RecipePattern(
    ["i",
     "h"],
    HAFT_ENTRY, (0, 0))
patterns["pike"] = RecipePattern(
    ["i",
     "p",
     "p"],
    POLE_ENTRY, (0, 0))
patterns["lance"] = RecipePattern(
    ["i",
     "p",
     "h"],
    HAFT_POLE, (0, 0))
patterns["halberd"] = RecipePattern(
    [" i",
     "ip",
     "i "],
    POLE_ENTRY, (0, 1))
patterns["warhammer"] = RecipePattern(
    ["ii",
     " h"],
    HAFT_ENTRY, (0, 0))
patterns["throwing_axe"] = RecipePattern(
    ["hi",
     " i"],
    HAFT_ENTRY, (0, 1))
patterns["hammer"] = RecipePattern(
    ["iii",
     "iii",
     " h "],
    HAFT_ENTRY, (0, 1))
patterns["throwing_knife"] = RecipePattern(
    ["hi"],
    HAFT_ENTRY, (0, 1))
patterns["longbow"] = RecipePattern(
    ["hwi",
     "w s",
     "iss"],
    BOW_KEYS, (0, 2))
patterns["crossbow"] = RecipePattern(
    ["bsi",
     "sw ",
     "i h",],
    CROSSBOW_KEYS, (2, 0))
patterns["javelin"] = RecipePattern(
    ["pi"],
    POLE_ENTRY, (0, 1))
patterns["battleaxe"] = RecipePattern(
    ["iii",
     "isi",
     " h "],
    STICK_HAFT, (0, 1))
patterns["mace"] = RecipePattern(
    [" ii",
     " si",
     "h  "],
    STICK_HAFT, (0, 2))
patterns["boomerang"] = RecipePattern(
    ["iww",
     "w  ",
     "w  "],
    BOOMERANG_KEYS, (0, 0))
patterns["glaive"] = RecipePattern(
    [" i ",
     " i ",
     "ip "],
     POLE_ENTRY, (0, 1))
patterns["staff"] = RecipePattern(
    [" p ",
     " i ",
     "   "],
    POLE_ENTRY, (1, 1))

def gen_traditional_recipe_for_weapon(weapon_name, mat_definition, pattern, mod_name):
    pattern_dict = pattern.keys.copy()
    pattern_dict["i"] = mat_definition.ingot_entry
    gen_dict = {
        "type": "minecraft:crafting_shaped",
        "pattern": pattern.pattern,
        "key": pattern_dict,
        "result": {
            "item": mod_name + ":" + weapon_name + "_" + mat_definition.mat_name
        },
        "conditions": mat_definition.conditions
    }
    with open(weapon_name + "_" + mat_definition.mat_name + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile)

def does_pattern_have_i(pattern):
    long_string = ''.join(pattern)
    print(long_string)
    return "i" in long_string


def gen_replace_tip_recipe_for_weapon(weapon_name, mat_definition, pattern, mod_name):
    pattern_dict = pattern.keys.copy()
    pattern_dict["t"] = mat_definition.tip_entry
    patCopy = [x for x in pattern.pattern]
    trow, tcol = pattern.tip
    tipReplace = list(patCopy[trow])
    tipReplace[tcol] = 't'
    patCopy[trow] = ''.join(tipReplace)
    if does_pattern_have_i(patCopy):
        pattern_dict["i"] = mat_definition.ingot_entry
        gen_dict = {
            "type": "minecraft:crafting_shaped",
            "pattern": patCopy,
            "key": pattern_dict,
            "result": {
                "item": mod_name + ":" + weapon_name + "_" + mat_definition.mat_name
            },
            "conditions": mat_definition.conditions
        }
        with open(weapon_name + "_" + mat_definition.mat_name + '.json', 'w') as outfile:
            json.dump(gen_dict, outfile)
    else:
        print("weapon has no i in recipe", weapon_name, mat_definition.mat_name)
        gen_dict = {
            "type": "forge:ore_shapeless",
            "ingredients": [
            mat_definition.tip_entry,
            {
              "item": mod_name + ":" + weapon_name + "_" + mat_definition.mat_name.split('_')[0],
              "data": 0
            }
            ],
            "result": {
                "item": mod_name + ":" + weapon_name + "_" + mat_definition.mat_name
            },
            "conditions": mat_definition.conditions
        }
        with open(weapon_name + "_" + mat_definition.mat_name + '.json', 'w') as outfile:
              json.dump(gen_dict, outfile)


MOD_NAME = "spartanfire"

ALL_WEAPONS = ['katana', 'greatsword', 'longsword', 'saber', 'rapier',
                'spear', 'dagger', 'pike', 'lance', 'halberd', 'warhammer',
                'throwing_axe', 'hammer', 'throwing_knife', 'longbow',
                'crossbow', 'javelin', 'battleaxe', 'mace', 'boomerang',
                'staff', 'glaive']

def gen_recipe_for_single_item_transform(start_mod, result_mod, 
    start_weapon, result_weapon, item, start_material, result_material, start_data, result_data, item_data):
    gen_dict = {
          "type": "forge:ore_shapeless",
          "ingredients": [
            {
              "item": item,
              "data": item_data
            },
            {
              "item": start_mod + ":" + start_weapon + "_" + start_material,
              "data": start_data
            }
          ],
          "result": {
            "item": result_mod + ":" + result_weapon + "_" + result_material,
            "data": result_data,
            "count": 1
        }
    }
    with open(result_weapon + "_" + result_material + '.json', 'w') as outfile:
        json.dump(gen_dict, outfile) 

for weapon in ALL_WEAPONS:
    gen_recipe_for_single_item_transform(MOD_NAME, MOD_NAME,
        weapon, weapon, "iceandfire:fire_dragon_blood", "dragonbone", "fire_dragonbone", 0, 0, 0)
    gen_recipe_for_single_item_transform(MOD_NAME, MOD_NAME,
        weapon, weapon, "iceandfire:ice_dragon_blood", "dragonbone", "ice_dragonbone", 0, 0, 0)

for mat_definition in mats:
    for weapon in ALL_WEAPONS:
        if mat_definition.replace_tip:
            gen_replace_tip_recipe_for_weapon(weapon, mat_definition, patterns[weapon], MOD_NAME)
        else:
            gen_traditional_recipe_for_weapon(weapon, mat_definition, patterns[weapon], MOD_NAME)


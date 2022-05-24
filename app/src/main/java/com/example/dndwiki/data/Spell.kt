package com.example.dndwiki.data

//val spells = listOf(
//    Spell("1 action",
//        "Wizard, Sorcerer",
//        DamageType("Acid"),
//        "Instantaneous",
//        "acid-splash",
//        0,
//        "Acid Splash",
//        School("Conjuration"),
//        "/api/spells/acid-splash",
//        "You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a dexterity saving throw or take 1d6 acid damage."),
//
//    Spell("1 bonus action",
//        "Cleric",
//        DamageType("Force"),
//        "1 minute",
//        "spiritual-weapon",
//        2,
//        "Spiritual Weapon",
//        School("Evocation"),
//        "/api/spells/spiritual-weapon",
//        "You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make a melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier."),
//
//    Spell("1 action",
//        "Sorcerer, Warlock, Wizard",
//        DamageType("Necrotic"),
//        "Instantaneous",
//        "circle-of-death",
//        6,
//        "Circle of Death",
//        School("Necromancy"),
//        "/api/spells/circle-of-death",
//        "A sphere of negative energy ripples out in a 60-foot radius sphere from a point within range. Each creature in that area must make a constitution saving throw. A target takes 8d6 necrotic damage on a failed save, or half as much damage on a successful one.")
//
//)

data class Spell(
    val casting_time: String,
    val dndclasses: String,
    val damagetype: DamageType,
    val duration: String,
    val index: String,
    val level: Int,
    val name: String,
    val school: School,
    val url: String,
    val description: String
)
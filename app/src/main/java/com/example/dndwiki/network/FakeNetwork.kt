package com.example.dndwiki.network

import com.example.dndwiki.data.DamageType
import com.example.dndwiki.data.School
import com.example.dndwiki.data.Spell

class FakeNetwork {

    private var spells = listOf(
        Spell(
            "1 action",
            "Wizard, Sorcerer",
            DamageType("Acid"),
            "Instantaneous",
            "acid-splash",
            0,
            "Acid Splash",
            School("Conjuration"),
            "/api/spells/acid-splash",
            "You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a dexterity saving throw or take 1d6 acid damage."
        ),

        Spell(
            "1 bonus action",
            "Cleric",
            DamageType("Force"),
            "1 minute",
            "spiritual-weapon",
            2,
            "Spiritual Weapon",
            School("Evocation"),
            "/api/spells/spiritual-weapon",
            "You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make a melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier."
        ),

        Spell(
            "1 action",
            "Sorcerer, Warlock, Wizard",
            DamageType("Necrotic"),
            "Instantaneous",
            "circle-of-death",
            6,
            "Circle of Death",
            School("Necromancy"),
            "/api/spells/circle-of-death",
            "A sphere of negative energy ripples out in a 60-foot radius sphere from a point within range. Each creature in that area must make a constitution saving throw. A target takes 8d6 necrotic damage on a failed save, or half as much damage on a successful one."
        ),

        Spell(
            "1 action",
            "Sorcerer, Warlock, Wizard",
            DamageType("Poison"),
            "Instantaneous",
            "poison-spray",
            0,
            "Poison Spray",
            School("Conjuration"),
            "/api/spells/poison-spray",
            "You extend your hand toward a creature you can see within range and project a puff of noxious gas from your palm. The creature must succeed on a constitution saving throw or take 1d12 poison damage."
        )
    )

    fun getSpells(): List<Spell> {

        return spells
    }
}
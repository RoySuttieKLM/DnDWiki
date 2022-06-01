package com.example.dndwiki.network

import com.example.dndwiki.data.Spell

class FakeNetwork {

    val spells = listOf(
        Spell("1 action",
            "Wizard, Sorcerer",
            "Acid",
            "Instantaneous",
            "acid-splash",
            0,
            "Acid Splash",
            "Conjuration",
            "/api/spells/acid-splash",
            "You hurl a bubble of acid. Choose one creature within range, or choose two creatures within range that are within 5 feet of each other. A target must succeed on a dexterity saving throw or take 1d6 acid damage."
        ),
        Spell("1 action",
            "Wizard",
            "Acid",
            "Instantaneous",
            "acid-arrow",
            2,
            "Acid Arrow",
            "Evocation",
            "/api/spells/acid-arrow",
            "A shimmering green arrow streaks toward a target within range and bursts in a spray of acid. Make a ranged spell attack against the target. On a hit, the target takes 4d4 acid damage immediately and 2d4 acid damage at the end of its next turn. On a miss, the arrow splashes the target with acid for half as much of the initial damage and no damage at the end of its next turn."
        ),

        Spell("1 bonus action",
            "Cleric",
            "Force",
            "1 minute",
            "spiritual-weapon",
            2,
            "Spiritual Weapon",
            "Evocation",
            "/api/spells/spiritual-weapon",
            "You create a floating, spectral weapon within range that lasts for the duration or until you cast this spell again. When you cast the spell, you can make a melee spell attack against a creature within 5 feet of the weapon. On a hit, the target takes force damage equal to 1d8 + your spellcasting ability modifier."
        ),

        Spell("1 action",
            "Sorcerer, Warlock, Wizard",
            "Necrotic",
            "Instantaneous",
            "circle-of-death",
            6,
            "Circle of Death",
            "Necromancy",
            "/api/spells/circle-of-death",
            "A sphere of negative energy ripples out in a 60-foot radius sphere from a point within range. Each creature in that area must make a constitution saving throw. A target takes 8d6 necrotic damage on a failed save, or half as much damage on a successful one."
        ),

        Spell(
            "1 action",
            "Sorcerer, Warlock, Wizard",
            "Poison",
            "Instantaneous",
            "poison-spray",
            0,
            "Poison Spray",
            "Conjuration",
            "/api/spells/poison-spray",
            "You extend your hand toward a creature you can see within range and project a puff of noxious gas from your palm. The creature must succeed on a constitution saving throw or take 1d12 poison damage."
        ),

        Spell(
            "1 action",
            "Bard, Sorcerer, Warlock, Wizard",
            "Slashing",
            "Concentration,\n 1 min.",
            "cloud-of-daggers",
            2,
            "Cloud of Daggers",
            "Conjuration",
            "/api/spells/cloud-of-daggers",
            "You fill the air with spinning daggers in a cube 5 feet on each side, centered on a point you choose within range. A creature takes 4d4 slashing damage when it enters the spell’s area for the first time on a turn or starts its turn there."
        )
    )
}

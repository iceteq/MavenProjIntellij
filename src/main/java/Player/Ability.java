package Player;

public abstract class Ability {

}

class NoHealingAbility extends Ability {

}

class MiniHeal extends Ability {
    // like heal, but slow
}

class Heal extends MiniHeal {
    // like meditate, but instant
}

class GrandHeal extends Heal {
    // like heal, instant, but heals more hp
}
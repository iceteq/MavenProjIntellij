package Player;

public abstract class Ability {

}


class Meditate extends Ability {
    // like heal, but slow
}

class Heal extends Meditate {
    // like meditate, but instant
}

class GrandHeal extends Heal {
    // like heal, instant, but heals more hp
}
package exe.weazy.marvelapp.state

import exe.weazy.marvelapp.model.Character

interface CharactersState {
    class Default : CharactersState
    class Loading : CharactersState
    class Error(val msg: String? = null) : CharactersState
    class Loaded(val data : List<Character>) : CharactersState
}


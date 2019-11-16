package exe.weazy.marvelapp.state


interface CharactersState {
    class Loading : CharactersState
    class Error(val msg: String? = null) : CharactersState
    class Loaded(val msg: String? = null) : CharactersState
}


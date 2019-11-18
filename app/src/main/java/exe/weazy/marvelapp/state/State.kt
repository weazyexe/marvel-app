package exe.weazy.marvelapp.state


interface State {
    class Loading : State
    class Error(val msg: String? = null) : State
    class Loaded(val msg: String? = null) : State
}


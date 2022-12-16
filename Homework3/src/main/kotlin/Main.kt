/*
HOMEWORK 3 (PROJECT)
STUDENT ID: B221202903
NAME: AFIFAH NABILAH
SURNAME: BINTI MOHD SUHAIMI
COURSE NAME: SWE303 DESIGN PATTERNS

Summary about design pattern;
There are 3 classes involved in memento pattern which are memento, originator, and caretaker.
In this design pattern, memento class holds the same state data as the originator, and it has constructor method.
in the originator class, it creates memento which contain snapshot of current state. Memento will help originator
to restore its internal state. In the caretaker class, it will save multiple state to maintain list of memento objects.
It will add memento to the list and retrieve memento from the list based on index.
The main function shows that:
-The first state is "Strawberry" (previous state)
-The second state is "Kiwi" (previous state)
-The third state is "Watermelon" (current state)
 */


import kotlin.collections.ArrayList

class MementoState(var state: String)

class OriginatorState {

    var state : String? = null

    fun saveStateIntoMemento(): MementoState {
        return MementoState(state!!)
    }

    fun getStateFromMemento(mementoState: MementoState) {
        state = mementoState.state
    }
}

class CaretakerState {

    private val mementoStateList: MutableList<MementoState> = ArrayList()
    fun addMementoState(mementoState: MementoState) {
        mementoStateList.add(mementoState)
    }

    operator fun get(index: Int): MementoState {
        return mementoStateList[index]
    }
}

fun main(args: Array<String>) {

    val originatorState = OriginatorState()
    originatorState.state = "Strawberry"

    val caretakerState = CaretakerState()
    caretakerState.addMementoState(originatorState.saveStateIntoMemento())
    originatorState.state = "Kiwi"

    caretakerState.addMementoState(originatorState.saveStateIntoMemento())
    originatorState.state = "Watermelon"

    println("Originator Current State: " + originatorState.state!!)
    println("Originator restoring to previous state...")

    originatorState.getStateFromMemento(caretakerState[1])
    println("Originator Current State: " + originatorState.state!!)
    println("Again restoring to previous state...")

    originatorState.getStateFromMemento(caretakerState[0])
    println("Originator Current State: " + originatorState.state!!)

}



package models

object CountingModel {
    private var count = 0;

    def getCount(): Int = this.synchronized { count }
    def increment(): Unit = this.synchronized { count += 1 }

}
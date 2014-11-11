package cellPatterns

/**
 * Created by jluis on 10/11/14.
 */
class CellPattern {

  def calculateAutomata(){
    def matrix = getInfoFromFile()
    def matrixSize = matrix.size(), countTimes = 0
    setIntoFileMatrix(iterateAutomata(matrix, 10, countTimes))

  }

  def getInfoFromFile(){
    def matrix = []
    def file = new File("/tmp/matrix.txt")
      file.eachLine{it->
        matrix.add it.toString().toCharArray()
      }
    matrix
  }

  def iterateAutomata(matrix, times, countTimes){

   def newMatrix = [], matrixSize = matrix.size()

      matrix.eachWithIndex{verticalObject, indexV ->
          def newArrayElement = []
          verticalObject.eachWithIndex{horizontalObject, indexH ->
            def countLives = 0
            if(indexV > 0){
              countLives += matrix[indexV-1][indexH]=='*'? 1:0
              if(indexH > 0)
                countLives += matrix[indexV-1][indexH-1]=='*'? 1:0
              if(indexH < matrixSize-1)
                countLives += matrix[indexV-1][indexH+1]=='*'? 1:0

            }
            if(indexV < matrixSize-1){
              countLives += matrix[indexV+1][indexH]=='*'? 1:0
              if(indexH > 0)
                countLives += matrix[indexV+1][indexH-1]=='*'? 1:0
              if(indexH < matrixSize-1)
                countLives += matrix[indexV+1][indexH+1]=='*'? 1:0
            }
            if(indexH > 0)
              countLives += matrix[indexV][indexH-1]=='*'? 1:0
            if(indexH < matrixSize-1)
              countLives += matrix[indexV][indexH+1]=='*'? 1:0
            if((matrix[indexV][indexH] == '.' && countLives == 3 )||(matrix[indexV][indexH] == '*' && (countLives ==3 || countLives ==2)))
              newArrayElement.add '*'
            else
              newArrayElement.add '.'
          }
          newMatrix.add newArrayElement
      }
      countTimes ++
      newMatrix = newMatrix
      if(countTimes < times)
        iterateAutomata(newMatrix, times, countTimes)
      else
       newMatrix
  }

  def setIntoFileMatrix(matrix){
    def file = new File('/tmp/newMatrix.txt')
    def out = file.newPrintWriter()
    matrix.each{it->
      def str = ''
      it.each{vec-> str+=vec}
      out.println(str)
    }
    out.close()
    matrix
  }
}

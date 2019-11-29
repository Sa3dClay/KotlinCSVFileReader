package myModel

import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException

class CSVReader {
    
    fun readCSV(path: String): List<String> {
        var data = listOf<String>()
        var fileReader: BufferedReader? = null
        
        try {
            var line: String?
            fileReader = BufferedReader(FileReader(path))
            // Read CSV header
            fileReader.readLine()
            // Read the file line by line starting from the second line
            line = fileReader.readLine()
            
            while (line != null) {
                val tokens = line.split(",")
                if (tokens.isNotEmpty()) {
                    println(tokens)
                    data = data.plus(tokens)
                }
                line = fileReader.readLine()
            }
        } catch (e: Exception) {
            println("Reading CSV Error!: $e")
            
        } finally {
            try {
                fileReader?.close()
            } catch (e: IOException) {
                println("Closing fileReader Error!: $e")
            }
        }
        
        return data
    }
    
}

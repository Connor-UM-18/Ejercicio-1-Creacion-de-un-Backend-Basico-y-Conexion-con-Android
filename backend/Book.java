package com.example.tarea3ejercicio2;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Clase que representa un libro con título, autores y URL de la portada.
 */
public class Book {
    @SerializedName("title")
    private String title;

    @SerializedName("author_name")
    private List<String> authors;

    @SerializedName("cover_i")
    private int coverId;

    /**
     * Obtiene el título del libro.
     * @return El título del libro.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtiene el nombre del primer autor del libro.
     * Si no hay autores disponibles, devuelve "Autor desconocido".
     * @return El nombre del primer autor o "Autor desconocido".
     */
    public String getAuthors() {
        return (authors != null && !authors.isEmpty()) ? authors.get(0) : "Autor desconocido";
    }

    /**
     * Obtiene la URL de la portada del libro.
     * Si no hay coverId disponible, devuelve null.
     * @return La URL de la portada o null.
     */
    public String getCoverUrl() {
        return coverId > 0 ? "https://covers.openlibrary.org/b/id/" + coverId + "-M.jpg" : null;
    }
}
const express = require("express");
const cors = require("cors");

const app = express();
app.use(cors());

// Definir un endpoint en "/hola"
app.get("/hola", (req, res) => {
    res.json({ mensaje: "Hola Mundo" });
});

// Configurar el puerto 8080
const PORT = 8080;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en http://localhost:${PORT}`);
});

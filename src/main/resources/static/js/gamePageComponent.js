
export default {
    data() {
        return {
            saludo: "¿Cómo estás?"
        }
    },
    methods: {
        saveGame: function () {
            console.log("Montado desde una funcion");
            metodoPrivado();
        }
    },
    mounted() {
        this.saveGame()
    },
    template: `
        <div>
            <p>Hola Javi</p>
            <p>{{saludo}}</p>
        </div>
        
    `

}


function metodoPrivado() {
    console.log('Montado desde un metodo privado');
    
}
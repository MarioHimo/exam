// scripts.js

// Funzioni per mostrare le diverse sezioni
function showHome() {
    document.getElementById('content').innerHTML = `
        <h1>Benvenuti nella Biglietteria del Teatro</h1>
        <p>Seleziona un'opzione dal menu per iniziare.</p>
    `;
}

function showSpettacoli() {
    document.getElementById('content').innerHTML = `
        <h1>Gestione degli Spettacoli</h1>
        <div id="teatro-list">
            <!-- I dettagli degli spettacoli verranno inseriti qui tramite JavaScript -->
        </div>
    `;
document.addEventListener('DOMContentLoaded', () => {
    const spettacoliContainer = document.getElementById('spettacoli-container');

    fetch('http://localhost:9074/api/spettacoli') // Cambia l'URL con quello della tua API
        .then(response => response.json())
        .then(spettacoli => {
            spettacoli.forEach(spettacolo => {
                console.log(spettacolo);
                // Crea un elemento card
                const card = document.createElement('div');
                card.className = 'col-md-4';

                card.innerHTML = `
                    <div class="card">
                        <img src="${spettacolo.imgUrl || 'https://via.placeholder.com/300x200'}" class="card-img-top" alt="${spettacolo.titolo}">
                        <div class="card-body">
                            <h5 class="card-title">Titolo: ${spettacolo.titolo}</h5>
                            <p class="card-text">Autore: ${spettacolo.autore}</p>
                            <p class="card-text">Regista: ${spettacolo.regista}</p> <p class="card-text">${spettacolo.prezzo}€</p>
                            <a href="#" class="btn btn-primary">Prenota Ora</a>
                        </div>
                    </div>
                `;

                // Aggiungi la card al container
                spettacoliContainer.appendChild(card);
            });
        })
        .catch(error => {
            console.error('Errore durante il recupero degli spettacoli:', error);
        });
});
}

function showPrenotazioni() {
    document.getElementById('content').innerHTML = `
        <h1>Prenotazioni</h1>
        <p>Qui puoi visualizzare e gestire le tue prenotazioni.</p>
    `;
}

function showLogin() {
    document.getElementById('content').innerHTML = `
        <h1>Login</h1>
        <form id="loginForm">
            <label for="codiceCliente">Codice Cliente:</label>
            <input type="text" id="codiceCliente" name="codiceCliente" required>
            <button type="button" onclick="login()">Accedi</button>
        </form>
        <p id="error" style="color: red; display: none;">Codice Cliente errato. Riprova.</p>
    `;
}

function logout() {
    document.getElementById('content').innerHTML = `
        <h1>Logout</h1>
        <p>Sei stato disconnesso.</p>
    `;
}

// Funzione di login
function login() {
    const codiceCliente = document.getElementById('codiceCliente').value;
    const errorElement = document.getElementById('error');
    
    // Verifica del codice cliente tramite chiamata API
    fetch(`http://localhost:9074/api/clienti/${codiceCliente}`)
        .then(response => {
            if (response.status === 404) { // Se il cliente non esiste
                throw new Error('Cliente non trovato');
            }
            if (!response.ok) {
                throw new Error('Errore nella risposta dal server');
            }
            return response.json();
        })
        .then(data => {
            if (data) { // Se il cliente esiste
                errorElement.style.display = 'none';
                alert('Login effettuato con successo!');
                showHome(); // Torna alla home dopo il login
            } else {
                errorElement.style.display = 'block';
                errorElement.textContent = 'Codice Cliente errato. Riprova.';
            }
        })
        .catch(error => {
            console.error('Errore:', error);
            errorElement.style.display = 'block';
            errorElement.textContent = 'Errore di connessione. Riprova più tardi.';
        });
}


// Mostra la home page all'inizio
showHome();

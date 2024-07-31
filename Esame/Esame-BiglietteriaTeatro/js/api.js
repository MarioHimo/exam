// Funzioni per chiamare le API
const API_BASE_URL = 'http://localhost:9074/api'; // Modifica l'URL base secondo la tua configurazione


/**
 * Effettua una richiesta per autenticare il cliente con il codice cliente.
 * @param {string} codiceCliente - Il codice cliente per l'autenticazione.
 * @returns {Promise<boolean>} - Ritorna true se l'autenticazione è riuscita, altrimenti false.
 */
async function authenticateCliente(codiceCliente) {
    try {
        const response = await fetch(`${API_BASE_URL}/authenticate`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ codiceCliente })
        });

        const data = await response.json();
        return data.isValid; // Supponiamo che l'API restituisca { isValid: true/false }
    } catch (error) {
        console.error('Errore durante l\'autenticazione:', error);
        return false;
    }
}

/**
 * Recupera l'elenco degli spettacoli disponibili dal backend.
 * @returns {Promise<Array>} - Ritorna un array di oggetti spettacolo.
 */
async function fetchSpettacoli() {
    try {
        const response = await fetch(`${API_BASE_URL}/spettacoli`);
        const data = await response.json();
        return data.spettacoli; // Supponiamo che l'API restituisca { spettacoli: [...] }
    } catch (error) {
        console.error('Errore durante il recupero degli spettacoli:', error);
        return [];
    }
}

/**
 * Recupera le prenotazioni del cliente dal backend.
 * @param {string} codiceCliente - Il codice cliente per recuperare le prenotazioni.
 * @returns {Promise<Array>} - Ritorna un array di oggetti prenotazione.
 */
async function fetchPrenotazioni(codiceCliente) {
    try {
        const response = await fetch(`${API_BASE_URL}/prenotazioni?codiceCliente=${codiceCliente}`);
        const data = await response.json();
        return data.prenotazioni; // Supponiamo che l'API restituisca { prenotazioni: [...] }
    } catch (error) {
        console.error('Errore durante il recupero delle prenotazioni:', error);
        return [];
    }
}

/**
 * Crea una nuova prenotazione per un cliente.
 * @param {string} codiceCliente - Il codice cliente che effettua la prenotazione.
 * @param {number} spettacoloId - L'ID dello spettacolo da prenotare.
 * @returns {Promise<boolean>} - Ritorna true se la prenotazione è riuscita, altrimenti false.
 */
async function createPrenotazione(codiceCliente, spettacoloId) {
    try {
        const response = await fetch(`${API_BASE_URL}/prenotazioni`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ codiceCliente, spettacoloId })
        });

        const data = await response.json();
        return data.success; // Supponiamo che l'API restituisca { success: true/false }
    } catch (error) {
        console.error('Errore durante la creazione della prenotazione:', error);
        return false;
    }
}


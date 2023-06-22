import React, { useState, useEffect } from 'react';
import styles from "./App.module.css";

function App() {
  const [ethPrice, setEthPrice] = useState(null);

  useEffect(() => {
    // Function to fetch the current ETH price
    const fetchEthPrice = async () => {
      try {
        // const response = await fetch('https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd');
        // const data = await response.json();
        // const price = data.ethereum.usd;
        // setEthPrice(price);
      } catch (error) {
        console.error('Error fetching ETH price:', error);
      }
    }

    // (1) Fetching First time
    fetchEthPrice();

    const interval = setInterval(fetchEthPrice, 10000);
    // [New] Clearing Interval when Component is unmounted.
    return () => clearInterval(interval);
  }, []);


  return (
    <div className="App">
      <header className={styles.header}>Dashboard Header</header>

      <main className={styles.main}>
        <h1>Coin Price</h1>
        <div className="price">{ethPrice ? `$${ethPrice}` : 'Loading...'} </div>
      </main>

      <footer className={styles.footer}>Dashboard Footer</footer>
    </div>
  );
}

export default App;

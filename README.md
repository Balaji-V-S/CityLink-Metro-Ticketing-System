# 🚇 CityLink-Metro Ticketing System

A **Java console-based project** that computes metro ticket fares based on configurable **rule sets**.  
The project demonstrates **strong OOP concepts, SOLID principles**, and a **3-Layer Architecture** (UI → Service → DAO).
---

## Rule Set
- ✅ **Base Fare**: ₹25 irrespective of line.
- ✅ **Peak Period Pricing**: Identifies peak travel hours (8 AM – 10 AM, 6 PM – 8 PM).
- ✅ **Transfer Window**: Free rides within **30 minutes** of the last ticket purchase.
- ✅ **Night Discount**: 20% off between **10 PM – Midnight**.
- ✅ **Post-Midnight Discount**: 35% off between **Midnight – 4 AM**.
- ✅ Extensible **Rule Engine**: New rules can be added without changing existing ones.

---

## 📖 Fare Rules Implemented

| Rule | Description |
|------|-------------|
| **R1** | Base Fare is always ₹25 |
| **R2** | Peak Period: 8 AM – 10 AM and 6 PM – 8 PM (No discount applied, normal base fare charged) |
| **R3** | Transfer Window: Within 30 minutes of last purchase → Fare = Free |
| **R4** | Night Discount: 20% discount (10 PM – 12 AM) |
| **R5** | Post-Midnight Discount: 35% discount (12 AM – 4 AM) |

---

## 🏗️ Project Structure  
```plaintext
CityLink-Metro-Ticketing-System/
│── src/
│   ├── com.citylink.ui/          # Console UI (Main class)
│   ├── com.citylink.models/      # Models (Ticketig Logs, Passenger, etc.)
│   ├── com.citylink.dao/         # DAO layer (in-memory data store)
│   ├── com.citylink.service/     # Business logic & Fare calculation
│   ├── com.citylink.utility/     # Utilities (time, validation, constants)
│   └── com.citylink.exceptions/  # Custom exceptions
│
│── README.md
│── pom.xml                       # Dependency & build management
```



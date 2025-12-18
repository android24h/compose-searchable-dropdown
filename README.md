# Searchable TextField with ExposedDropdownMenu (Jetpack Compose)

A **simple UI-only example** demonstrating how to add search functionality inside a `TextField` using `ExposedDropdownMenuBox` in **Jetpack Compose**.

This snippet focuses purely on **UI behavior**, not on data architecture or ViewModel usage.

---

## ✨ What This Example Shows

- Search inside a `TextField`
- Filtering a list based on user input
- Using `ExposedDropdownMenuBox` correctly
- Basic state handling with `remember`
- A clean and minimal Compose UI pattern

---

## 📌 Scope of This Snippet

- ✅ UI-only demonstration  
- ❌ Not intended as a full MVVM or production-ready solution  
- ❌ No ViewModel or remote data source  

This is intentionally kept simple to showcase the search behavior.

---

## 🧩 Code Example

```kotlin
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchableDropdown() {

    var text by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    val items = listOf(
        "Android",
        "Kotlin",
        "Java",
        "Compose",
        "XML",
        "ViewModel",
        "LiveData",
        "Room",
        "DataStore",
        "Coroutines"
    )

    val filteredItems = remember(text) {
        if (text.isEmpty()) emptyList()
        else items.filter { it.contains(text, ignoreCase = true) }
    }

    ExposedDropdownMenuBox(
        expanded = expanded && filteredItems.isNotEmpty(),
        onExpandedChange = { expanded = it }
    ) {

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                expanded = true
            },
            label = { Text("Enter Android Tool") },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )

        ExposedDropdownMenu(
            expanded = expanded && filteredItems.isNotEmpty(),
            onDismissRequest = { expanded = false }
        ) {
            filteredItems.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item) },
                    onClick = {
                        text = item
                        expanded = false
                    }
                )
            }
        }
    }
}
```

---

## 🛠 Tech Stack

- Kotlin
- Jetpack Compose
- Material 3

---

## 📄 License

MIT License

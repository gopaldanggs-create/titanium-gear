# Titanium Gear (Fabric, Minecraft 26.3)

Adds:
- **Titanium Ore** - rare underground veins (y 0-110) in **Windswept Gravelly Hills** only. Needs an iron pickaxe or better. Drops Raw Titanium (Fortune works, Silk Touch keeps the ore) and a little XP.
- **Raw Titanium** and **Titanium Ingot** (smelt or blast raw titanium or the ore).
- **Titanium armor** (helmet, chestplate, leggings, boots), **tools** (sword, pickaxe, axe, shovel, hoe) and a **Titanium Mace**. Everything appears in the vanilla creative tabs, recipes are in the recipe book from the start.

## Recipes
| Item | Recipe |
|---|---|
| Armor / tools | Same shapes as diamond gear, using Titanium Ingots (and sticks for tools) |
| Titanium Mace | Ingot, Ingot, Ingot / (empty) Heavy Core (empty) / (empty) Breeze Rod (empty) |
| Titanium Ingot | Smelt or blast Raw Titanium or Titanium Ore |

## Easiest: let GitHub build the jar (nothing to install)
1. Create a new GitHub repository and upload everything in this folder (keep the `.github` folder).
2. Open the **Actions** tab, pick the **build** workflow (click *Run workflow* if it hasn't started).
3. When it finishes, open the run and download the **titanium-gear-jar** artifact. Unzip it: the mod is `titanium-gear-1.0.0.jar` (ignore `-sources`).

## Build locally
Requires **Java 25**.

1. Gradle wrapper files `gradlew`/`gradlew.bat`/`gradle-wrapper.jar` are not included. Either open this folder in IntelliJ IDEA (it sets up Gradle from `gradle/wrapper/gradle-wrapper.properties`), or install Gradle 9.7+ and run `gradle wrapper` once.
2. `./gradlew build` - the mod jar is in `build/libs/` (use the one without `-sources`).
3. Drop the jar and **Fabric API 0.161.0+26.3** (or newer for 26.3) into your `mods` folder with Fabric Loader 0.19.5+.

Dev run: `./gradlew runClient`.

Tune stats in `TitaniumMaterials.java` / `ModItems.java`; ore rarity in
`src/main/resources/data/titanium_gear/worldgen/placed_feature/titanium_ore.json`.

# Surredstone Plugin
Plugin for managing groups of players using Villages

## Features
**Village Default chat**: Transforms the player's default chat into the village chat

## Commands
**/global or /g**: Sends a message to everyone in the server, ignoring the player village.

**/village or /vil**: Manages the villages.

**/village info [village-abbreviation]**: Get the abbreviation, name and flag from a village or every village.

## Settings
To edit the plugin villages, open the file ``villages.yml`` and follow the pattern.

## Developing
**Required**: Gradle, Java, Minecraft Server with plugin support.

1. Add the server into ``/server``
2. Run ``gradle`` to download Bukkit dependencies
3. Run ``gradle jar`` to build the plugin into ``/build/libs/Surredstone.jar`` and ``/server/plugins/Surredstone.jar``
4. Start the Minecraft server
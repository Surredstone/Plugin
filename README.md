# Surredstone Plugin
Plugin for managing groups of players using Villages

## Features
**Village Default chat**: Transforms the player's default chat into the village chat
**Intervillage communication**: Allows you to send a message to everyone in a certain village
**Global chat**: Sends a message to everyone in the server
**Discord integration**: Splits every chat in its own Discord channel, with your own bot

## Commands
**/global or /g**: Sends a message to everyone in the server, ignoring the player village.

**/village or /vil**: Manages the villages.

**/village info [village-abbreviation]**: Get the abbreviation, name and flag from a village or every village.

## Settings
The main config file consists in two settings:
- ``discord.token``: your bot's Discord secret token
- ``discord.main``: the channel id to use as the global channel

The village config file stores all the plugin villages data
- ``id.name``: complete village name
- ``id.abbreviation``: an abbreviation for the village name
- ``id.color``: a color for the village syntax
- ``id.info``: a link (or text) that have informations about the village
- ``id.discord``: the village Discord channel id

## Developing
**Required**: Gradle, Java, Minecraft Server with plugin support.

1. Add the server into ``/server``
2. Run ``gradle`` to download the plugin dependencies
3. Run ``gradle shadowjar`` to build the plugin into ``/build/libs/Surredstone.jar`` and ``/server/plugins/Surredstone.jar``
4. Start the Minecraft server
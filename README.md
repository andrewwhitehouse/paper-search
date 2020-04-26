# paper-search

## Demo produced for EUvsVirus Hackathon 24th-26th April 2020

Retrieve open access papers, initially from Euro PMC, 
and do useful things with the results.

## Pre-requisites

Install [Java](https://openjdk.java.net/) and [Leiningen](https://leiningen.org/).

## Usage

`lein run "your search query in quotes" [result page size]`

Queries the Euro PMC API to return documents matching the query and summaries the results in a Markdown file.

Currently processes only the medRxiv pages (pre-prints), so the actual number of results may be significantly 
smaller than the specific page size.

Allows you to run simple queries and have a usable result with minimal setup.

## Current limitations

- Uses medRviv results only
- Lacks the download retry and dictionary cross-referencing in the 
  [getpapers / AMI](https://github.com/petermr/openVirus/blob/master/INSTALLING.md) tools.

## License

Copyright © 2020 Andrew Whitehouse

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.

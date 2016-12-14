/**
 * tessellate-transform4j JavaScript API.
 * Requires tessellate-transform as 'Tessellate' in the global context.
 */

function toNativeArray(items) {
  var array = []
  if (!items) return
  for each (var item in items) {
    array.push(item)
  }
  return array
}

function toNativeObject(map) {
  var object = {}
  if (!map) return
  for each (var key in map.keySet()) {
    object[key] = map.get(key)
  }
  return object
}

function transform(file, opts, space) {
  var nativeOpts = {
    root: opts.root,
    typePrefix: opts.typePrefix,
    jsonMap: {
      typeKeys: toNativeArray(opts.jsonMap.typeKeys),
      childrenKeys: toNativeArray(opts.jsonMap.childrenKeys),
      literalKeys: toNativeArray(opts.jsonMap.literalKeys),
      ignoreKeys: toNativeArray(opts.jsonMap.ignoreKeys),
      typeMap: toNativeObject(opts.jsonMap.typeMap)
    }
  }
  return JSON.stringify(Tessellate.transform(file, nativeOpts), null, space)
}
